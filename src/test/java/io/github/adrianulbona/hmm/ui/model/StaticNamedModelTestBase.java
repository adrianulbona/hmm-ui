package io.github.adrianulbona.hmm.ui.model;

import io.github.adrianulbona.hmm.Emission;
import io.github.adrianulbona.hmm.Transition;
import org.junit.Before;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by adrianulbona on 09.03.2016.
 */
public class StaticNamedModelTestBase {

    protected StaticNamedModelData data;
    protected NamedState healthy;
    protected NamedState fever;
    protected List<NamedState> states;
    protected NamedObservation dizzy;
    protected NamedObservation cold;
    protected NamedObservation normal;
    protected List<NamedObservation> observations;

    @Before
    public void setUp() throws Exception {
        this.data = new StaticNamedModelData();

        this.healthy = new NamedState("healthy");
        this.fever = new NamedState("fever");

        this.states = asList(this.healthy, this.fever);

        this.dizzy = new NamedObservation("dizzy");
        this.cold = new NamedObservation("cold");
        this.normal = new NamedObservation("normal");

        this.observations = asList(this.dizzy, this.cold, this.normal);

        this.data.getStates().add(healthy);
        this.data.getStates().add(fever);

        this.data.getObservations().add(dizzy);
        this.data.getObservations().add(cold);
        this.data.getObservations().add(normal);

        this.data.getInitialProbabilities().put(healthy, 0.6);
        this.data.getInitialProbabilities().put(fever, 0.4);

        this.data.getEmissionProbabilities().put(new Emission<>(healthy, dizzy), 0.1);
        this.data.getEmissionProbabilities().put(new Emission<>(healthy, cold), 0.4);
        this.data.getEmissionProbabilities().put(new Emission<>(healthy, normal), 0.5);
        this.data.getEmissionProbabilities().put(new Emission<>(fever, dizzy), 0.6);
        this.data.getEmissionProbabilities().put(new Emission<>(fever, cold), 0.3);
        this.data.getEmissionProbabilities().put(new Emission<>(fever, normal), 0.1);

        this.data.getTransitionProbabilities().put(new Transition<>(healthy, healthy), 0.7);
        this.data.getTransitionProbabilities().put(new Transition<>(healthy, fever), 0.3);
        this.data.getTransitionProbabilities().put(new Transition<>(fever, fever), 0.6);
        this.data.getTransitionProbabilities().put(new Transition<>(fever, healthy), 0.4);
    }
}
