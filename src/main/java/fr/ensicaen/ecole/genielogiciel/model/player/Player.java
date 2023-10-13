package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.board.Action.Action;
import fr.ensicaen.ecole.genielogiciel.model.board.tiles.Tile;
import fr.ensicaen.ecole.genielogiciel.model.player.hardskills.HardSkill;
import fr.ensicaen.ecole.genielogiciel.model.player.softskills.*;
import fr.ensicaen.ecole.genielogiciel.presenter.BoardControllerPresenter;
import fr.ensicaen.ecole.genielogiciel.presenter.PawnPresenter;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Player {
    private final String _name;
    private final SoftSkill _softSkill;
    private ArrayList<HardSkill> _hardSkills;
    private String _schoolingName;
    private final String _softSkillName;
    private int _currentTileIndex;
    private BoardControllerPresenter _boardController;
    private final PawnPresenter _pawn;

    public Player(String name, String schoolingName) {
        _name = name;
        _schoolingName = schoolingName;
        _softSkill = new SoftSkillRandomFactory().createSoftSkill();
        _softSkillName = _softSkill.getName();
        _hardSkills = new ArrayList<>();
        _currentTileIndex = 0;
        _pawn = new PawnPresenter();
    }

    public Player(String name, ArrayList<HardSkill> hardSkills, String schoolingName) {
        this(name, schoolingName);
        _hardSkills = hardSkills;
    }

    public Player() {
        _name = "";
        _softSkill = new Rigorous();
        _softSkillName = _softSkill.getName();
        _hardSkills = new ArrayList<>();
        _currentTileIndex = 0;
        _pawn = new PawnPresenter();
    }

    // WARNING: this method is used by the tableView, do not remove it!
    public String getSchooling() {
        return _schoolingName;
    }

    public String getName() {
        return _name;
    }

    // WARNING: this method is used by the tableView, do not remove it!
    public String getMathematicsLevel() {
        return String.valueOf(getHardSkillLevel(fr.ensicaen.ecole.genielogiciel.model.player.hardskills.Mathematics.class));
    }

    // WARNING: this method is used by the tableView, do not remove it!
    public String getComputerScienceLevel() {
        return String.valueOf(getHardSkillLevel(fr.ensicaen.ecole.genielogiciel.model.player.hardskills.ComputerScience.class));
    }

    // WARNING: this method is used by the tableView, do not remove it!
    public String getSoftSkillName() {
        return _softSkillName;
    }

    public SoftSkill getSoftSkill() {
        return _softSkill;
    }

    public int getHardSkillLevel(Class<? extends HardSkill> subject) {
        for (HardSkill skill : _hardSkills) {
            if (skill.getClass() == subject) {
                return skill.getScore();
            }
        }
        return 0;
    }

    public void setHardSkillLevel(Class<? extends HardSkill> subject, int score) {
        for (HardSkill skill : _hardSkills) {
            if (skill.getClass() == subject) {
                skill.setScore(score);
                return;
            }
        }
        try {
            HardSkill skill = subject.getConstructor().newInstance();
            skill.setScore(score);
            _hardSkills.add(skill);

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToLevelOfHardSkill(Class<? extends HardSkill> subject, int scoreToAdd) {
        for (HardSkill skill : _hardSkills) {
            if (skill.getClass() == subject) {
                skill.addToScore(scoreToAdd);
                return;
            }
        }
        setHardSkillLevel(subject, scoreToAdd);
    }

    public void moveWithoutTileEffect(int moveCount) {
        _currentTileIndex += moveCount;
    }

    public void move(int diceResult) {
        int diceResultModifiedBySoftSkill = _softSkill.modifyDiceRoll(diceResult);
        Tile tile = _boardController.getTile(_currentTileIndex + diceResultModifiedBySoftSkill);
        _currentTileIndex = tile.getPositionIndex();
        Action action = tile.fetchInstruction(this);
        action.performAction(this);
        Tile finalTile = _boardController.getTile(_currentTileIndex);
        _pawn.draw(finalTile);
    }

    public void setBoardController(BoardControllerPresenter boardController) {
        _boardController = boardController;
    }

    public void initPawn(AnchorPane board, int id) {
        Tile firstTile = _boardController.getTile(_currentTileIndex);
        _pawn.initPawn(board, id);
        _pawn.draw(firstTile);
    }

    public int getPosition() {
        return _currentTileIndex;
    }

    public boolean isOnWinningTile() {
        return _currentTileIndex == _boardController.getLastTileIndex();
    }
}