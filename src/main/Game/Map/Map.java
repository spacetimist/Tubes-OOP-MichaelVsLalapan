package main.Game.Map;

import main.GUI.WindowPanel;
import main.Game.Map.Area.BaseArea;
import main.Game.Map.Area.CommonArea;
import main.Game.Map.Area.PoolArea;
import main.Game.Map.Area.ZombieSpawnArea;

import java.awt.*;

public class Map {
    WindowPanel wp;
    CommonArea common;
    PoolArea pool;
    BaseArea base;
    ZombieSpawnArea spawn;
    public Map(WindowPanel wp) {
        this.wp = wp;
        common = new CommonArea(wp);
        pool = new PoolArea(wp);
        base = new BaseArea(wp);
        spawn = new ZombieSpawnArea(wp);
    }
    public void draw(Graphics2D g2) {
        common.draw(g2);
        pool.draw(g2);
        base.draw(g2);
        spawn.draw(g2);
    }
}
