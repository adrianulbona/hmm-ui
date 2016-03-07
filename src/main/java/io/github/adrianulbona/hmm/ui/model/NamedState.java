package io.github.adrianulbona.hmm.ui.model;


import io.github.adrianulbona.hmm.State;
import lombok.Data;

/**
 * Created by adrianulbona on 06.03.2016.
 */
@Data
public class NamedState implements State {

    private final String name;
}
