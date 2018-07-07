<!--这里是一级标题-->
#MacDown
<!--这里是Logo,通过图片地址-->
![MacDown logo](http://macdown.uranusjr.com/static/images/logo-160.png)

<!--这里是给字体加粗-->
Hello there! I'm **Lanygae**, an graduated student in **Hunan University**.


<!--二级标题带下划线-->
## MacDown And I

<!--这里是超链接-->
**Markdown** is a plain bla bla bla. found more in [here](http://www.baidu.com)

**MacDown** is created more convinience.

<!--截图-->
![Macdown screenshot](https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=234992636,89591102&fm=27&gp=0.jpg)

I support all the original Markdown syntaxes.But I can do so much more! Various poplular but non-standard syntaxes can be turend on/off from the[**Mardown** preference pane](http://www.baidu.com)


## The Basics

Before I tell you about all the extra syntaxes and capabilities I have, I'll introduce you to the basics of standard markdown. If you already know markdown, and want to jump straight to learning about the fancier things I can do, I suggest you skip to the [**Markdown** preference pane](#markdown-pane). Lets jump right in.  

<!--三级标题-->
### Line Breaks

To force a line break, put two spaces and a newline (return) at the end of the line.

<!--无序列表,如果加两个空格,就会切断-->
* This two-line bullet
wont' break
* This two-line bullet  
will break

Here is the code:
<!--代码-->

	public class Hello{
		public static void main(Strint[] args){  
			System.out.println("Hello World");
		}
	}
	
### Strong and Emphasize
<!--增强-->
**Strong**: (Command+B)
<!--强调-->
*Emphasize*

### Headers (like this one!)

	Header 1
	=========
	Header 
	---------
or 

	# Header 1
	## Header 2
	### Header 3
	#### Header 4
	##### Header 5
	###### Header 6

### Links and Email
#### Inline
<!--Email邮箱-->
Just put angle brackets around and email and it becomes clickable: <lllyyyggg@dingtalk.com>

Perhaps you want some link text like this:[百度](http://www.baidu.com)

<!--小块文字-->
`[百度](http://www.baidu.com)`(The title is optional)

#### Referece style

### Images
#### Inline 
![Alt text](path/or/url/to.jpg)


### Lists
* foo
* foo2
	* works
		1. child1
		2. child2
		3. [child3](child3)

### Inline Code
`Inline code` is indicated by surrounding it with backticks:
`` `Inline code` ``

### Block Code
If your indent at least four spaces or one tab, i'll display a code block.

	public class Demo{
		public static void main(String[] args){
			System.out.println("Hello World");
		}
	}

***
## <a name="markdown-pane"></a>The Markdown Preference Pane


This is where i keep all preferences related to how i parse markdown into html.

<!--文本格式化-->
***SmartyPants*** `$` and `#`


### Blocking formatting
#### Table

This ia a table
<!--表格居中-->

|First Name | Second Name|
|:----------:|:-------:|
 Lan | Yage |
 Shu | Fang |

#### <a name="fenced-code-block">Fenced Code Block</a>

This is a fenced code block:

```
print('Hello world');
```
You can also use single tag like `~` or `` ` `` to do something.

~~~
print('Hello World');
~~~


| Optionname | result |
|:----:|:----:|
||So <em> Amazing </em>|
||So <del> Amazing </del>|
||So <u> Amazing </u>|
||So <q> Amazing </q>|
||So <mark> Amazing </mark>|
||So <sup> Amazing </sup>|
||So <http://amazing.com>|
||So <sup> Amazing </sup>|



<math display="block">
	<msubsup><mi>A</mi> <mi>S</mi> <mi>T</mi></msubsup>
	<mo>=</mo>
	<mi>B</mi>
</math>


### Jekyll front-matter

```
---
title : "Todat is a good day"
content: "I met a girl today"
---
```
