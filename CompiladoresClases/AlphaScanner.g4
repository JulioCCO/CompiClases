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
Const: 'const';
Var: 'var';
Switch: 'switch';
Case: 'case';
Break: 'break';
Default: 'default';
End: 'end';
LeftBracket: '{';
RightBracket: '}';

String : QuoMark(Letter|Digit|WS)*QuoMark;

Num     : Digit+;
ID      : Letter (Letter|Digit)*;
fragment Letter  : [a-z]|[A-Z];
fragment Digit   : [0-9];
fragment QuoMark : '"';

Commet : '//' ~[\r\n]* -> skip;
WS      : [ \t\n\r]+ -> skip ;