parser grammar AlphaParser;

// Import the lexer tokens
options {
  tokenVocab = AlphaScanner;
}

// Start symbol
program: singleCommand EOF                                                          #programAST;

// Production rules

command : singleCommand (Semicolon singleCommand)*                                  #commandAST;

singleCommand:  ID Assign expression                                                #assignSingleCommandAST
              | methodCall                                                          #callSingleCommandAST
              | If expression Then singleCommand (Else singleCommand)?              #ifSingleCommandAST
              | While expression Do singleCommand                                   #whileSingleCommandAST
              | Let declaration In singleCommand                                    #letSingleCommandAST
              | Begin command End                                                   #blockSingleCommandAST
              ;


methodCall: ID LeftParen actualParam RightParen                                     #methodCallAST;

actualParam : expression (Comma expression)*                                        #actualParamAST;

declaration: singleDeclaration (Semicolon singleDeclaration)*                       #declarationAST ;

singleDeclaration: Const ID Tilde expression                                        #constSingleDeclarationAST
                    | Var ID Colon typeDenoter                                      #varDeclarationAST
              | (typeDenoter|VOID) ID LeftParen paramDecls RightParen singleCommand #methodSingleDeclaration;

idDeclaration : ID Colon typeDenoter                                                #idDeclAST;
paramDecls: idDeclaration (Comma idDeclaration)*                                    #paramDeclsAST;
typeDenoter: ID                                                                     #typeDenoterAST;

expression: primaryExpression (operator primaryExpression)*                         #expressionAST;

primaryExpression: NUM                                                              #numPrimaryExpressionAST
                  | ID                                                              #idPrimaryExpressionAST
                  | Char                                                            #charPrimaryExpressionAST
                  | LeftParen expression RightParen                                 #parenthesisPrimaryExpressionAST
                  | methodCall                                                      #methodCallPrimaryExpressionAST
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
