package backend;


import backend.Filesystem.CreateTestValues;

import java.io.IOException;

public class WavesExplorerTestRunner {

    public static void main(String[] args) throws IOException {

        GetPropertyValues properties = new GetPropertyValues();
        properties.getPropValues();

        CreateTestValues test = new CreateTestValues();
    }
}
