# Madcamp_first
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
  
    
    
## Authors
- Jiwoong Na
- Junmyong Lee
