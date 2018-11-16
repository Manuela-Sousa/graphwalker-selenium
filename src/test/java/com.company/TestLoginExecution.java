package com.company;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.junit.Test;
import java.io.IOException;

    public class TestLoginExecution {

        @Test
        public void testExecutor() throws IOException {
            Executor executor = new TestExecutor(LoginTest.class);
            executor.getMachine().getCurrentContext().setPathGenerator(new RandomPath(new EdgeCoverage(100)));
            Result result = executor.execute(true);
            if (result.hasErrors()) {
                for (String error : result.getErrors()) {
                    System.out.println(error);
                }
            }
            System.out.println("Done: [" + result.getResults().toString(2) + "]");
            
        }

    }

