exercicio primitiveWriteUTF

Neste exercicio seguiremos traballando os fluxos binarios de datos pero abora tratandoos como soporte de tipos de dato primitivos e valores String

DataOutputStream é unha clase que dispon dunha serie de  métodos  para que partindo  de fluxos binaros de datos  podamos escribir tipos primitivos de datos e valores String


DataInputStream é unha clase que dispon  dunha serie de  métodos  para que partindo  de fluxos binaros de datos  podamos ler tipos primitivos de datos e valores String  que previamente foron codificados nestes fluxos mediante DataOutputStream


Dado que DatainputStream admite como parámetro calquer clase herdada de InputStream , e BufferedInputStream cumpre este requisito,  o único que temos que facer para poder usar os metodos de DataInputStream e pasarlle como parmaetro un obxecto BufferedInputStream coma o traballado no exercicio anterior (exercicio3 : copybytesimaxe2)


Dado que DataOutputStream admite como parametro calquer clase herdada de OutputStream , e BufferedOutputStream cumpre este requisito o único que temos que facer para poder usar os metodos de DataOutputStream e pasarlle como parmaetro un obxecto BufferedOutputStream coma o traballado no exercicio anterior (exercicio3 : copybytesimaxe2)

APLICACION

Obxectivo: Propoñovos un desenvolver un proxecto chamado primitiveWriteUTF que consistirá grabar a mesma cadea  de texto tres veces consecutivas nun ficheiro denominado texto3.txt usando o metodo writeUTF e amosar o tamaño do ficheiro cada vez que grabamos unha cadea , para posteriormente recuperalos (ler ditas cadeas dende o ficheiro).

cadea a grabar : "o tempo está xélido"



IMPORTANTE:

para saber se cando desenvolvemos a lectura alcanzamos o fin do ficheiro podemos usar o metodo .available() da clase DataInputStream que devolvera o valor 0 cando xa non quede nada por ler .


metodos a usar :

da clase DataOutputStream :  size(), writeUTF(String)

	o metodo size() devolve o tamaño en bytes do ficheiro no que estamos a escribir
	o metodo writeUTF(String) escribe a cadea que se pasa como parametro

da clase DataInputStream : available(), readUTF()

	o metodo available() devolta o valor 0 se xa se leron todos os bytes do ficheiro
	o metodo readUTF() lee calquera  String que fose grabado previamente nun ficheiro co  metodo  writeUTF(String)


Ter en cota que writeUTF(String) escribe tipicamente 1 byte por cada caracter do String que lle pasamos como parámetro  ( pero pode escribir ata 3 bytes por caracter  dependendo do caracter ) e antepon a dito String  2 bytes que conteñen a lonxitude en numero de bytes do String.

E dicir que se por exemplo o String a grabar é o texto "o tempo está xélido" a sua escritura ocupara 23 bytes porque os caracteres normais e os blancos ocupan  1 byte por caracter , namentras que e as vogais con acento ocupan 2 bytes cada unha. Vexamos o cálculo a ollo :
"o tempo está xélido": 14 caracteres normais  + 3 blancos  + 2 vogais  acentuados =>

2 bytes (que antepoñen a cadea para indicar a sua lonxitude) + 14 + 3 + 2*2 = 23 bytes



o resultado da execucion podería  ser o seguinte:

escribindo a cadea: o tempo está xélido
tamano do ficheiro: 23 bytes
escribindo a cadea: o tempo está xélido
tamano do ficheiro: 46 bytes
escribindo a cadea: o tempo está xélido
tamano do ficheiro: 69 bytes
tamano final  do ficheiro: 69 bytes
quedan: 69 bytes por ler
cadea: o tempo está xélido
quedan: 46 bytes por ler
cadea: o tempo está xélido
quedan: 23 bytes por ler
cadea: o tempo está xélido
Xa non queda nada por ler




Observacions :
Podemos comprobar que se intentamos abrir a o ficheiro de texto  text3.txt co editor gedit non o permite. debemos usar nano , vi , emacs ou outro editor non grafico  e comprobaremos a forma en que foron grabadas as  cadeas.
podemos ver o contido do ficheiro de texto en hexadecimal e en codigo ASCII  dende unha terminal con:  hexdump -C nome_ficheiro  ou ben en binario puro : xxd -b nome_ficheiro
mostrar lonxitude en bytes do ficheiro: wc -c nome_ficheiro


