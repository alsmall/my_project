package com.aismall.idea_sport.dao;

import com.aismall.idea_sport.bean.MainMenu;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMainMenus();
}
