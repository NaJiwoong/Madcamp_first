# Madcamp_first: My Todo
2019 Fall KAIST  

## Environment
- Android Studio 29.0.2
- Kotlin

## Library
- Glide 3.7.0

## Description  
&nbsp;&nbsp;&nbsp;&nbsp;This repository is for madcamp project of first week. In this project, we make an android application with three tabs. Each tab has its own content respectively: Address book, Photo gallery, Undecided content.  

  
#### Tab1
&nbsp;&nbsp;&nbsp;&nbsp;This tab is for address book. We implemented it as getting all phone numbers and names, and show them. Implementing, we used ListView, and adapter to show the contents. To get permission, we implemented a pop-up which requires the user to
agree to permit read contacts.  
  
    
#### Tab2
&nbsp;&nbsp;&nbsp;&nbsp;This tab is for Gallery. We implemented it as getting all photos in local gallery and show them as gridview. In the implementation, we used Glide library. To get permission, we implemented a pop-up which requires the user to agree to permit read and wirte external local storage. 
  
  
#### Tab3
&nbsp;&nbsp;&nbsp;&nbsp;This tab is for ToDoList. We implemented it simply getting input text from Edittext and save the input into the textfile in the local storage. After store the data, we make it able to show a list of all input texts that it got. We made a remove button for each list element, so that users can remove any list element by simply cliking the remove button.
  
### Note
- permission  
&nbsp;&nbsp;&nbsp;&nbsp;We need permission to access contacts on the phone, and local storage in order to get contacts from the phone for the Tab1, and get photos from the phone album for the Tab2, and also we have to store 'Todo list' in the local storage as txt file. So we put code below in the 'manifest/AndroidManifest.xml'   <br><br>\<uses-permission android:name="android.permission.READ_CONTACTS"/><br>\<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/><br>\<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/><br><br>&nbsp;&nbsp;&nbsp;&nbsp;In addition, we have to request users permissions, so we implemented requesting function(checkVerify()) and overrided function 'onRequestPermissionResult'. After user agree all permission, the function calls a function 'startApp()', which will actually start the actual application.  
- UI in tab three  
&nbsp;&nbsp;&nbsp;&nbsp;In tab three, we have EditText layer, where users can enter their input and save it. We had to make it possible that EditText layer go up with keyboard as keyboard appears for user input. For this function, we set android:windowSoftInputMode to 'adjustResize' and set layout_weight to '1'. <br>&nbsp;&nbsp;&nbsp;&nbsp;Plus, we implemented a enter button in keyboard, as well as UI button, to be able to save user input to local stoarge. We could do it by use 'setOnKeyListener' to check if the key is ACTION_DOWN and if the key is KEYCODE_ENTER. After then, if the text in the EditText is not empty, the application save the input from the EditText.
    
    
## Authors
- Jiwoong Na
- Junmyong Lee
