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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ApacheConfigFile extends BaseFile {

    public ApacheConfigFile(String filepath) throws FileNotFoundException {
        super(filepath);
    }

    public ApacheConfigFile(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public boolean write(ArrayList<String> lines) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Attributes parseToAtributes(ArrayList<String> lines) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
