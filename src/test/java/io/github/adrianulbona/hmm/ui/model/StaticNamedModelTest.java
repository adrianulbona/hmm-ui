package io.github.adrianulbona.hmm.ui.model;

import com.google.gson.Gson;
import io.github.adrianulbona.hmm.Transition;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.Assert.assertEquals;

/**
 * Created by adrianulbona on 09.03.2016.
 */
public class StaticNamedModelTest extends StaticNamedModelTestBase {

    @Test
    public void testConsistency() throws URISyntaxException, IOException {
        final Path jsonPath = Paths.get(StaticNamedModelTest.class.getResource("static-named-hmm.json").toURI());
        final StaticNamedModel model =
                StaticNamedModel.from(new Gson().fromJson(newBufferedReader(jsonPath), StaticNamedModelData.class));
        assertEquals(model.initialProbabilityFor(healthy), 0.6, 0.0001);
        assertEquals(model.initialProbabilityFor(fever), 0.4, 0.0001);

        final int numberOfStates = this.states.size();
        this.observations.forEach(observation -> {
            assertEquals(numberOfStates, model.emissionProbabilitiesFor(observation).size());
            this.observations.forEach(nextObservation -> {
                final Map<Transition<NamedState>, Double> transitions =
                        model.transitionProbabilitiesFor(observation, nextObservation);
                assertEquals(numberOfStates * numberOfStates, transitions.size());
            });
            assertEquals(numberOfStates, model.getReachableStatesFor(observation).size());
        });
    }
}