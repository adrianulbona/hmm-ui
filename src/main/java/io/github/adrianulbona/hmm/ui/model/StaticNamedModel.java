package io.github.adrianulbona.hmm.ui.model;

import io.github.adrianulbona.hmm.*;
import io.github.adrianulbona.hmm.probability.ProbabilityCalculator;

import java.util.ArrayList;

/**
 * Created by adrianulbona on 06.03.2016.
 */
public class StaticNamedModel extends Model<NamedState, NamedObservation> {

    public StaticNamedModel(ProbabilityCalculator<NamedState, NamedObservation> pc,
            ReachableStateFinder<NamedState, NamedObservation> rcf) {
        super(pc, rcf);
    }

    public static StaticNamedModel from(StaticNamedModelData data) {
        final ProbabilityCalculator<NamedState, NamedObservation> probabilityCalculator =
                new ProbabilityCalculator<>(data.getInitialProbabilities()::get,
                        data.getEmissionProbabilities()::get, data.getTransitionProbabilities()::get);
        final ReachableStateFinder<NamedState, NamedObservation> reachableStateFinder =
                observation -> new ArrayList<>(data.getStates());
        return new StaticNamedModel(probabilityCalculator, reachableStateFinder);
    }
}
