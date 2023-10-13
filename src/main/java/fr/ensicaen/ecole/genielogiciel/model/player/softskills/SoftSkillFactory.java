package fr.ensicaen.ecole.genielogiciel.model.player.softskills;

public abstract class SoftSkillFactory {

    protected abstract SoftSkill getSoftSkill();

    public SoftSkill createSoftSkill() {
        return getSoftSkill();
    }
}
