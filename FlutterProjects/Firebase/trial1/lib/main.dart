// ignore: import_of_legacy_library_into_null_safe
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() => runApp(Home());

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  FirebaseAuth auth = FirebaseAuth.instance;
  String username = "", password = "";

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        backgroundColor: Colors.white,
        body: Padding(
          padding: EdgeInsets.all(20),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextFormField(
                decoration: InputDecoration(
                  hintText: "Email ID",
                  labelText: "Email Id",
                  labelStyle: TextStyle(color: Colors.red, fontSize: 20),
                ),
                onChanged: (val) {
                  username = val;
                },
              ),
              SizedBox(
                height: 20,
              ),
              TextFormField(
                decoration: InputDecoration(
                  hintText: "Password",
                  labelText: "Enter your Password",
                  labelStyle: TextStyle(color: Colors.red, fontSize: 20),
                ),
                onChanged: (val) {
                  password = val;
                },
              ),
              SizedBox(
                height: 50,
              ),
              GestureDetector(
                onTap: () async{
                  login();
                },
                child: Container(

                  width: 200,
                  height: 50,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(30),
                    color: Colors.blueGrey,
                  ),
                  child: Center(child: Text("LOGIN",style: TextStyle(fontSize: 20),),),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
 Future<dynamic> login() async
  {
    try {
      UserCredential userCredential = await FirebaseAuth.instance.signInWithEmailAndPassword(
          email: username,
          password: password
      );
    } on FirebaseAuthException catch (e) {
      if (e.code == 'user-not-found') {
        print('No user found for that email.');
      } else if (e.code == 'wrong-password') {
        print('Wrong password provided for that user.');
      }
    }
  }
}
