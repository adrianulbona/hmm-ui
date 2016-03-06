package io.github.adrianulbona.hmm.ui;

import static spark.Spark.get;

public class Hello {

    public static void main(String[] args) {
        get("/", (req, res) -> "hello hmm");
    }
}