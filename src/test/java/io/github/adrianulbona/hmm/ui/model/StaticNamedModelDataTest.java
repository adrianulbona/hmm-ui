package io.github.adrianulbona.hmm.ui.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adrianulbona on 06.03.2016.
 */
public class StaticNamedModelDataTest extends StaticNamedModelTestBase {


    @Test
    public void serialization() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.enableComplexMapKeySerialization().setPrettyPrinting();
        final Gson gson = gsonBuilder.create();
        final String json = gson.toJson(this.data);
        assertEquals(this.data, gson.fromJson(json, StaticNamedModelData.class));
    }
}