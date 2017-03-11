/*
 * Cobalt Programming Language Compiler
 * Copyright (C) 2017  Cobalt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package compiler.structure.parsers.loops

import compiler.structure.blocks.Block
import compiler.structure.blocks.loops.WhileBlock
import compiler.structure.parsers.Parser
import compiler.tokenizer.Tokenizer

/*
need to make parameter single variable names instead as cant define a variable in an ifs...
 */
class WhileParser extends Parser[WhileBlock] {

  /**
    * A list of all regular expressions
    *
    * @return
    */
  override def getRegexs: List[String] = List("while")

  override def parse(superBlock: Block, tokenizer: Tokenizer): WhileBlock = {
    new WhileBlock(superBlock)
  }
}
