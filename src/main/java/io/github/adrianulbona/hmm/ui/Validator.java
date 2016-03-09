package io.github.adrianulbona.hmm.ui;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.github.adrianulbona.hmm.ui.model.StaticNamedModelData;
import lombok.Data;
import spark.Request;

import static spark.Spark.post;

public class Validator implements RouteProvider {

    @Override
    public void registerRoutes() {
        final Gson gson = new Gson();
        post("/validate", (req, res) -> validate(req), gson::toJson);
    }

    public ValidationResponse validate(Request req) {
        try {
            new Gson().fromJson(req.body(), StaticNamedModelData.class);
            return ValidationResponse.valid();
        } catch (JsonSyntaxException e) {
            return ValidationResponse.invalid(e.getMessage());
        }
    }

    public enum Status {
        VALID,
        INVALID
    }

    @Data
    public static class ValidationResponse {
        private final Status status;
        private final String details;

        public static ValidationResponse valid() {
            return new ValidationResponse(Status.VALID, null);
        }

        public static ValidationResponse invalid(String details) {
            return new ValidationResponse(Status.INVALID, details);
        }
    }
}