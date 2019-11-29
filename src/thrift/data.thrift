namespace java com.myNetty.thrift.generated

typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String
//封装对象
struct Persion{
   1:optional String username,
   2:optional int age,
   3:optional boolean married
}
//封装异常
exception DataException{
   1:optional String message,
   2:optional String callStack,
   3:optional String date
}
//封装方法
service PersionService{
    Persion getPersonByUserName(1:required String username) throws (1:DataException dateException),
    void savePersion(1:required Persion persion) throws(1:DataException dataException)
}
//com.myNetty.thrift --gen java src/com.myNetty.thrift/data.com.myNetty.thrift