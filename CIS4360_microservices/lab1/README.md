Jackie Gan
CIS 4360 Microservices
Carl Williams 

In this assignment, we will start Google Cloud Platform (GCP) and go over basic linux commands. <br />
<br />(a)
![](img\billing_screen.png)
<br />(b)
![](img\shell.png)
<br />(c)
![](img\commands.png)
linux commands:
- ls (list), this command list the current working directory
    - every time in GCP we type 'ls' it will print all current dir
- pwd (print working directory), this will show the current working directory
    - every time in GCP we type 'pwd' prints current working path, very useful when we check current path
- cd [dir](change directory), default will change to home directory, we can also change to root directory by cd / or change to any existing directory by cd dir
    - cd .. will go back to the parent directory
    - cd / will go to the root directory because / is root
- mkdir [dir] (make directory), mkdir dir will make a directory named dir
    - mkdir dir1 dir2 dir3 will make 3 directory in current directory
- '>' this will forward the output to something such as text file. So echo 'test' > test.txt will make a file named test.txt contain 'test'
    - ls > ls.txt will forward ls results to a ls.txt file
- 'cat' this will print out the file, very useful to see what contains in the text file
- echo [text], will just echo the text and print out the text

<br />(d)
![](img\GCP_tutorial.png)