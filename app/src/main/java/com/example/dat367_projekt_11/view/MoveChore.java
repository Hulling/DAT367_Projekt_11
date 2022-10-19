package com.example.dat367_projekt_11.view;

import com.example.dat367_projekt_11.models.Chore;
import com.example.dat367_projekt_11.models.Household;
/**
 * This is a interface which allow mainPageView and doneChoresView to share adapter.
 * @author  Hanna Harnesk
 */

public interface MoveChore {
    void moveChore(Chore chore, Household household);
}
