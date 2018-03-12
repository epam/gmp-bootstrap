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
 * dev@sample-sub-module/04-command-line.groovy -issueId SAND-1
 */


def baOs = new ByteArrayOutputStream()
def cli = new CliBuilder(usage: " ", stopAtNonOption: true, writer: new PrintWriter(baOs))
cli.issueId(args: 1, argName: 'id', 'JIRA issue ID to work with')
def options = cli.parse(cmdLine)

if (!options.issueId) {
    cli.usage()
    logger.info baOs.toString()
    return 1
}
logger.info("$cmdLine")
logger.info("$options.issueId")
return 0