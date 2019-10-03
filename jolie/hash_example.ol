include "type.iol"
include "string_utils.iol"
include "interface.iol"
include "console.iol"
include "runtime.iol"
include "file.iol"
include "security_utils.iol"

execution { single }

outputPort HashFileOutputPort
{
  Interfaces: HashFileInterface
}
//embedding per la gestione e creazione dell'hash
embedded
{
  Java: "file.hash.integrity.FileIntegrity" in HashFileOutputPort
}

main
{
  name="5MB.zip"
  toAbsolutePath@File("")(response);
  getParentPath@File(response)(PATH);
  PATH=PATH+"/files";
  with( exJile ) {
    .fileName=name;
    .content=" ";
    .path=PATH;
    .hash=" "
  };
  hashGenerator@HashFileOutputPort(exJile)(exJile);
  println@Console("HASH CALCOLATO: "+exJile.hash)()
}
