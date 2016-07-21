# Greek Roman (and Decimal) Numerals

This is a iminum project demonstrating handling of Greek and Roman numerals. Trivial, really, probably the only interesting part is that it can work with different character sets.

To build it, run:
```
mvn package
```
which will also execute the tests.

To run it, enter:
```
java -cp target/greek-roman-numerals-0.0.1-SNAPSHOT-jar-with-dependencies.jar gr.louridas.numerals.Numerals
```
or, if you are using MS-Windows,
```
java -cp target\greek-roman-numerals-0.0.1-SNAPSHOT-jar-with-dependencies.jar gr.louridas.numerals.Numerals -c Cp737
```
Note the `-c Cp737` part; that's where you indicate the encoding in use by your terminal window. If it is not Cp737, pass the appropriate one. If you do not pass anything, UTF-8 is assumed.

When the program starts you will get a prompt:
```
>> 
```
in which you can enter an arithmetic expression of the form `operand1 op operand2` or simply `operand`. The operands can be numbers in decimal, roman, or greek notation. The operand can be one of `+`, `-`, `*`, `/`. The result of the expression will be displayed in all three formats. To finish, enter an empty line.

## Known limitations

It works only for numbers up to 1000. It does not do any real checking; garbage in, garbage out.
