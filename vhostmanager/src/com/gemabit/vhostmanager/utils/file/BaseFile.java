/**
 * vHost - Virtual Host Manager.
 *
 * @copyright © Gemabit <www.gemabit.com> 2014
 * @license Apache License, Version 2.0
 *
 * Copyright 2014 Gemabit
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.gemabit.vhostmanager.utils.file;

import com.gemabit.vhostmanager.utils.Attributes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

abstract class BaseFile {

    /**
     * File object holder
     */
    protected File file;
    
    /**
     * Creates a BaseFile Object
     *
     * @param filepath
     * @throws FileNotFoundException
     */
    public BaseFile(String filepath) throws FileNotFoundException {
        this.file = new File(filepath);
        if (!this.file.isFile()) {
            throw new FileNotFoundException();
        }
    }

    /**
     * Creates a BaseFile Object
     *
     * @param file
     * @throws FileNotFoundException
     */
    public BaseFile(File file) throws FileNotFoundException {
        this.file = file;
        if (!this.file.isFile()) {
            throw new FileNotFoundException();
        }
    }

    /**
     * Loads the document data into the object
     *
     * @return boolean
     */
    abstract public boolean load();

    /**
     * Saves the data into the file
     *
     * @return boolean
     */
    abstract public boolean save();

    /**
     * Reads the file
     *
     * @return ArrayList<String>
     * @throws FileNotFoundException
     * @throws IOException
     */
    protected ArrayList<String> read() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(this.file);
        ArrayList<String> lines;

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line.trim());
            }
        }

        return lines;
    }

    /**
     * Writes the data on the file
     *
     * @param lines
     * @return boolean
     */
    protected boolean write(ArrayList<String> lines) {
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : lines) {
                bufferedWriter.append("\n".concat(line));
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Parses the ArrayList to a Attribute class
     *
     * @param lines
     * @return Attributes
     */
    abstract public Attributes parseToAtributes(ArrayList<String> lines);

    /**
     * Parses the ArrayList to a String
     *
     * @param lines
     * @return String
     */
    public String parseToString(ArrayList<String> lines) {
        String result = new String();

        for (String line : lines) {
            result = result.concat("\n").concat(line);
        }

        return result;
    }
}
