/*
Tipo che modella il concetto di file. Il Jile si catatterizza per:
.fileName e' il nome del file
.content e' il contenuto in base 64 del file
.path e' il percorso del file sulla rete
.hash e' l'hash del file, ci consente di capire se esso e' arrivato integro
*/

type Jile: void
{
  .fileName: string
  .content: any
  .path: string
  .hash: string
}
