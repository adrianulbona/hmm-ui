package io.github.adrianulbona.hmm.ui.model;

import io.github.adrianulbona.hmm.Observation;
import lombok.Data;

/**
 * Created by adrianulbona on 06.03.2016.
 */

@Data
public class NamedObservation implements Observation {

    private final String name;
}
