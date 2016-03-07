package io.github.adrianulbona.hmm.ui.model;

import com.google.gson.GsonBuilder;
import io.github.adrianulbona.hmm.Emission;
import io.github.adrianulbona.hmm.Transition;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by adrianulbona on 06.03.2016.
 */
public class StaticNamedModelTest {

    private StaticNamedModel model;
    private StaticNamedModelData data;

    @Before
    public void setUp() throws Exception {
        final StaticNamedModelData rawData = new StaticNamedModelData();

        final NamedState healthy = new NamedState("healthy");
        final NamedState fever = new NamedState("fever");

        final NamedObservation dizzy = new NamedObservation("dizzy");
        final NamedObservation cold = new NamedObservation("cold");
        final NamedObservation normal = new NamedObservation("normal");

        rawData.getStates().add(healthy);
        rawData.getStates().add(fever);

        rawData.getObservations().add(dizzy);
        rawData.getObservations().add(cold);
        rawData.getObservations().add(normal);

        rawData.getInitialProbabilities().put(healthy, 0.6);
        rawData.getInitialProbabilities().put(fever, 0.4);

        rawData.getEmissionProbabilities().put(new Emission<>(healthy, dizzy), 0.1);
        rawData.getEmissionProbabilities().put(new Emission<>(healthy, cold), 0.4);
        rawData.getEmissionProbabilities().put(new Emission<>(healthy, normal), 0.5);
        rawData.getEmissionProbabilities().put(new Emission<>(fever, dizzy), 0.6);
        rawData.getEmissionProbabilities().put(new Emission<>(fever, cold), 0.3);
        rawData.getEmissionProbabilities().put(new Emission<>(fever, normal), 0.1);

        rawData.getTransitionProbabilities().put(new Transition<>(healthy, healthy), 0.7);
        rawData.getTransitionProbabilities().put(new Transition<>(healthy, fever), 0.3);
        rawData.getTransitionProbabilities().put(new Transition<>(fever, fever), 0.6);
        rawData.getTransitionProbabilities().put(new Transition<>(fever, healthy), 0.4);

        this.data = rawData;
        this.model = StaticNamedModel.from(rawData);
    }

    @Test
    public void serialize() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.enableComplexMapKeySerialization().setPrettyPrinting();
        System.out.println(gsonBuilder.create().toJson(this.data));
    }
}