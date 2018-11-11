

package com.thmotaun.swingy.View.guiview;

import com.thmotaun.swingy.Controller.GameManager;
import com.thmotaun.swingy.Controller.MapGenerator;
import com.thmotaun.swingy.Database.DataBase;
import com.thmotaun.swingy.Model.GameCharacter;

/**
 * View
 */
public class View extends GameManager {

    public View(GameCharacter hero, GameViewGUI gameViewGUI) {
        this.hero = hero;
        this.gui = true;
        this.gameViewGUI = gameViewGUI;
    }

	@Override
	public void runGame() {
        if (hero == null) {
            System.out.println("No hero set");
            System.exit(1);
        }
        gameViewGUI.pushMessage(hero.getName() + " arrived in a new hostile environment");
        gameMap = MapGenerator.generateMap(hero);
    }
    
    public void updateHeroPosition() {
        gameMap.updateHeroPosition();
        DataBase.updateHero(hero);
    }
    
}