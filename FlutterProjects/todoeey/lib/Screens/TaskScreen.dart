import 'package:flutter/material.dart';
import 'package:todoeey/Widgets/task_list.dart';

class TaskScreen extends StatelessWidget {
  // const TaskScreen({Key? key}) : super(key: key);

  String taskname = "";
  Widget buildBottomSheet(BuildContext context) {
    return Container(
      color: Color(0xff757575),
      child: Container(
        padding: EdgeInsets.only(
          top: 20,
          left: 40,
          right: 40,
        ),
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.only(
              topRight: Radius.circular(30), topLeft: Radius.circular(30)),
        ),
        height: 300,
        child: Column(
          children: [
            Text(
              'Add Task',
              style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Colors.lightBlueAccent),
            ),
            SizedBox(
              height: 30,
            ),
            TextField(
              autofocus: true,
              textAlign: TextAlign.center,
              // keyboardType: TextInputType.text,
              decoration: InputDecoration(
                border: UnderlineInputBorder(),
              ),
              onChanged: (val) {
                taskname = val;
              },
            ),
            SizedBox(
              height: 60,
            ),
            GestureDetector(
              onTap: () {},
              child: Container(
                decoration: BoxDecoration(
                    color: Colors.lightBlueAccent,
                    borderRadius: BorderRadius.circular(30)),
                width: MediaQuery.of(context).size.width,
                height: 40,
                child: Center(
                    child: Text(
                  'Submit',
                  style: TextStyle(
                      color: Colors.white,
                      fontWeight: FontWeight.w500,
                      fontSize: 20),
                )),
              ),
            )
          ],
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.lightBlueAccent,
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            padding:
                EdgeInsets.only(top: 60.0, left: 30, right: 30, bottom: 30),
            child: Column(
              // mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                CircleAvatar(
                  backgroundColor: Colors.white,
                  radius: 30,
                  child: Icon(
                    Icons.list,
                    size: 40,
                    color: Colors.redAccent,
                  ),
                ),
                SizedBox(
                  height: 12,
                ),
                Text(
                  'Todoey',
                  style: TextStyle(
                      fontSize: 40,
                      color: Colors.white,
                      fontWeight: FontWeight.w700),
                ),
                Text(
                  '12 Tasks',
                  style: TextStyle(
                      fontSize: 18,
                      color: Colors.white,
                      fontWeight: FontWeight.w300),
                ),
                SizedBox(
                  height: 20,
                ),
              ],
            ),
          ),
          Expanded(
            child: Container(
              padding: EdgeInsets.only(left: 30, right: 10),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(20.0),
                  topRight: Radius.circular(20),
                ),
              ),
              child: TasksList(),
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          showModalBottomSheet(
            context: context,
            builder: buildBottomSheet,
          );
        },
        backgroundColor: Colors.yellow,
        child: Icon(
          Icons.add,
          size: 35,
          color: Colors.red,
        ),
      ),
    );
  }
}
