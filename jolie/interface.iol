/*
interfaccia che fa da tramite per la creazione dell'hash attraverso un embedding,
un Jile invia l'hash e il ricevente lo codifica.
*/
interface HashFileInterface
{
  RequestResponse:
    hashGenerator(Jile)(Jile)
}
