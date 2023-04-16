lexer grammar AlphaScanner;

// Tokens
Plus: '+';
Minus: '-';
Mult: '*';
Div: '/';
Mod: '%';
Equals: '==';
NotEquals: '!=';
LessThan: '<';
GreaterThan: '>';
LessThanOrEquals: '<=';
GreaterThanOrEquals: '>=';
Colon: ':';
Semicolon: ';';
Tilde: '~';
Comma: ',';
LeftParen: '(';
RightParen: ')';
Assign: ':=';
If: 'if';
Then: 'then';
Else: 'else';
While: 'while';
Do: 'do';
Let: 'let';
In: 'in';
Begin: 'begin';
End: 'end';
Const: 'const';
Var: 'var';
//TAREA PALABRAS RESERVADAS
Control: 'control';
Cover: 'cover';
Break: 'break';
PLAIN_TEXT : '"' (LETTER|DIGIT|WS)* '"';
Void : 'void';
//FIN DE TAREAS PALABRAS RESERVADAS
NUM     : DIGIT+;
ID      : LETTER (LETTER|DIGIT)*;
Char    : '\'' LETTER '\'';
fragment LETTER  : [a-z]|[A-Z];
fragment DIGIT   : [0-9];

COMMENT : '//' ~[\r\n]* -> skip;
WS      : [ \t\n\r]+ -> skip ;