package com.example.dat367_projekt_11.view;

import com.example.dat367_projekt_11.models.Chore;
/**
 * This is a interface which allows the adapter to listen to OnClick in chore card,
 * and access the clicked Chore.
 *
 * @author  Hanna
 */

public interface CheckboxClickListener {
     void CheckBoxClicked(Chore chore);
}
