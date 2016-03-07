package io.github.adrianulbona.hmm.ui.model;

import io.github.adrianulbona.hmm.Emission;
import io.github.adrianulbona.hmm.Transition;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by adrianulbona on 06.03.2016.
 */
@Data
public class StaticNamedModelData {

    private final Set<NamedState> states;
    private final Set<NamedObservation> observations;
    private final Map<NamedState, Double> initialProbabilities;
    private final Map<Emission<NamedState, NamedObservation>, Double> emissionProbabilities;
    private final Map<Transition<NamedState>, Double> transitionProbabilities;

    public StaticNamedModelData() {
        this.states = new HashSet<>();
        this.observations = new HashSet<>();
        this.initialProbabilities = new HashMap<>();
        this.emissionProbabilities = new HashMap<>();
        this.transitionProbabilities = new HashMap<>();
    }
}
