parser grammar AlphaParser;

// Import the lexer tokens
options {
  tokenVocab = AlphaScanner;
}

// Start symbol
program: singleCommand EOF                                              #programAST;

// Production rules

command : singleCommand (Semicolon singleCommand)*                      #commandAST;

singleCommand: ID Assign expression                                     #assingnSingleCommandAST
              | ID LeftParen expression RightParen                      #callSingleCommandAST
              | If expression Then singleCommand (Else singleCommand)?  #ifSingleCommandAST
              | While expression Do singleCommand                       #whileSingleCommandAST
              | Let declaration In singleCommand                        #letSingleCommandAST
              | Begin command End                                       #blockSingleCommandAST
              ;

declaration: singleDeclaration (Semicolon singleDeclaration)*           #declarationAST;

singleDeclaration: Const ID Tilde expression                            #constDeclarationAST
                    | Var ID Colon typeDenoter                          #varDeclarationAST;

typeDenoter: ID                                                         #typeDenoterAST;

expression: primaryExpression (operator primaryExpression)*             #expressionAST;

primaryExpression: Num                                                  #numPrimaryExpressionAST
                  | ID                                                  #idPrimaryExpressionAST
                  | LeftParen expression RightParen                     #groupPrimaryExpressionAST
                  ;

operator: Plus
        | Minus
        | Mult
        | Div
        | Mod
        | Equals
        | NotEquals
        | LessThan
        | GreaterThan
        | LessThanOrEquals
        | GreaterThanOrEquals
        ;