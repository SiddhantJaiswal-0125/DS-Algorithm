import 'package:counter_app/cubit/counter_cubit.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return BlocProvider(
      create: (context) => CounterCubit(),
      child: MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: MyHomePage(title: 'Flutter Demo Home Page'),
      ),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: BlocListener<CounterCubit, CounterState>(
        listener: (context, state) {
          if (state.increment) {
            Scaffold.of(context).showSnackBar(SnackBar(
              content: Text("Increment"),
              duration: Duration(seconds: 1),
            ));
          } else
            Scaffold.of(context).showSnackBar(SnackBar(
              content: Text("Decrement"),
              duration: Duration(seconds: 1),
            ));
        },
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              BlocBuilder<CounterCubit, CounterState>(
                builder: (context, state) {
                  return Text(
                    'Counter is ${state.counter}',
                  );
                },
              ),
              Row(
                children: [
                  FloatingActionButton(
                    onPressed: () {
                      BlocProvider.of<CounterCubit>(context).decrement();
                    },
                    child: Icon(Icons.remove),
                  ),
                  SizedBox(
                    width: 20,
                  ),
                  FloatingActionButton(
                    onPressed: () {
                      BlocProvider.of<CounterCubit>(context).increment();
                    },
                    child: Icon(Icons.add),
                  )
                ],
              )
            ],
          ),
        ),
      ),
      // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
