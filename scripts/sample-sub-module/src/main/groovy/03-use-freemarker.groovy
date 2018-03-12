/*
 *  /***************************************************************************
 * Copyright (c) 2017, EPAM SYSTEMS INC
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  ***************************************************************************
 */

/**
 * cmd line argument to start:
 * dev@sample-sub-module/03-use-freemarker.groovy
 */

import com.epam.dep.esp.common.freemarker.FreemarkerHelper

def variables = ['key1': 'value 1',
                 'key2': 'value 2',
                 'key3': ['value 3.1', 'value 3.2']]

FreemarkerHelper freemarker = new FreemarkerHelper(this.class.classLoader, '')
println(freemarker.processTemplate('03-use-freemarker.flt', variables))
return 0