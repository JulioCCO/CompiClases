package ast;

import java.util.LinkedList;

public class CommandAST extends AST{
     private SingleCommandAST singleCommand1;

     private LinkedList<SingleCommandAST> singleCommands;

     public CommandAST(SingleCommandAST singleCommand1, LinkedList<SingleCommandAST> singleCommands) {
          this.singleCommand1 = singleCommand1;
          this.singleCommands = singleCommands;
     }

        public SingleCommandAST getSingleCommand1() {
            return singleCommand1;
        }

        public LinkedList<SingleCommandAST> getSingleCommands() {
            return singleCommands;
        }

        public void setSingleCommand1(SingleCommandAST singleCommand1) {
            this.singleCommand1 = singleCommand1;
        }

        public void setSingleCommands(LinkedList<SingleCommandAST> singleCommands) {
            this.singleCommands = singleCommands;
        }
}
