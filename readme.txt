Welcome to Intergalactic Transactions @ Thoughtworks.

- Design pattern used are 
	1) Factory pattern
	   problem helps us to identify 5 kinds of transaction.
	   a) galactic symbol(symbol) ---maps --- roman symbol
	   b) Metal weight -- (maps) --- credits

	   c) galactic symbol weight (quantity) --- query
	   d) weight (quantity) + metal ----- query

	   e) invalid string

	2) Singleton design pattern 
	   - each type of transactions are done using a Singleton class of defined type.

- Class TransactionFactory return appropriate singleton object catering each type of given transaction.

- Interface TransactionManager is implemented by : 
	a) SymbolRomanMapper
	b) MetalCreditMapper
	c) QuantityQuery
	d) CreditQuery

	which have their own logic for executing the query.


- Various helper class are also present in Util package to assist the program
  GalacticSymbolToRomanConverter
  InputFileReader
  RomanSymbol
  RomanToArabicConverter


 - Custom exception - BadStringException is raised in case of incompatible or invalid string. 



 For further clarification , feel free to contact on :
 Prashantsundu@gmail.com
 9420082141