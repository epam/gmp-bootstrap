/*
 *  /***************************************************************************
 *  Copyright (c) 2017, EPAM SYSTEMS INC
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


package com.epam.gmp.web;

import com.epam.gmp.ScriptResult;
import com.epam.gmp.process.GroovyThread;
import com.epam.gmp.process.QueuedProcessService;
import com.epam.gmp.web.dto.Script;
import com.epam.gmp.web.exception.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class ScriptController {
    @Autowired
    QueuedProcessService processService;

    @RequestMapping(value = "/api/queue", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Object apiQueueScript(@Valid @RequestBody Script script, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Invalid Script", bindingResult);
        }

        Long start = System.currentTimeMillis();
        processService.execute(GroovyThread.class, script.getName(), script.getParams());
        return "Job has been triggered " + (System.currentTimeMillis() - start);
    }

    @RequestMapping(value = "/api/run", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Object apiRunScript(@Valid @RequestBody Script script, BindingResult bindingResult) throws ExecutionException, InterruptedException {
        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException("Invalid Script", bindingResult);
        }
        Future<ScriptResult<Object>> result = processService.execute(GroovyThread.class, script.getName(), script.getParams());
        return result.get();
    }
}
