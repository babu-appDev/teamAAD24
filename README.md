# teamAAD24-animation-challenge -> Note App 📓

One Paragraph of project description goes here. (We wil get to this later).

**NB: To all members, Fork this repo and edit this file to add your name under authors.**

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. In the top-right corner of the page, click Fork.
![](https://help.github.com/assets/images/help/repository/fork_button.jpg)

2. To keep it synced, check out this [link](https://help.github.com/en/articles/fork-a-repo).

## Contributing

Please read [CONTRIBUTING.md](https://github.com/babu-appDev/teamAAD24/blob/master/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to the project.

## Authors

* **babu-appDev** - [babu-appDev](https://github.com/babu-appDev)

## About The Project

### 1. ViewAnimation

This is the oldest type of animations. It was available since API 1. It has those 4 types of animations

    Alpha
    Scale
    Rotate
    Translate

And AnimationSet to wrap multiple animations. And you can call create them either from Java or XML. Here is an example from this repo [here](https://github.com/daimajia/AndroidViewAnimations).

![](http://ww3.sinaimg.cn/mw690/610dc034gw1ej75mi2w77g20c30jb4qr.gif)

```
TODO: Add code Snippets Showing Implementation of View Animation
```

### 2. Property Animation

Now let’s get to more advanced stuff. This class was introduces in Android 3.0. That’s a much bigger framework which allows to animate anything, not just views. First of all, I want to talk about some differences: it has default duration of 300 ms, if you animate views they stay at the animated position and default interpolator is AccelerateDecelerate. The root class  is Animator.

  * **Value Animator**

The main child in here is ValueAnimator it simply animates primitives like ints, floats, but for most cases you would want to apply those animated values to a view or any other objects. That’s where you set AnimatorUpdateListener and set values to you objects on each callback

  * **Object Animator**

Rather then using ValueAnimator and setting update listener you can use ObjectAnimator, which handles it for you. It looks much cleaner with it.

  * **View Property Animator**

Finally we got to the one that most of you probably use most of all. It’s just like ObjectAnimator, but it performs better if you change multiple properties simultaneously by calling invalidate() after all properties are animated. You can animate by absolute value or starting from current one (+/-) using -By suffix. 

Here is an example of Property animations which you can check out [here](https://github.com/codepath/android-complex-property-animations-demo).
<img src="http://i.imgur.com/ToeRvZK.gif" width="400" />

```
TODO: Add code Snippets Showing Implementation of Property Animation
```

### 3. Drawable Animation

In addition to those above we have Drawable Animation. I know your hear exploding already. What, twelve’s way to do fade out views, you might say? No, don’t worry, this one actually differs from previous.  AnimationDrawable is more like 2D game development. Because it’s frame drawable animation. For example, we have PNG’s of running hero, for each frame we set its duration, put into list and set in to any view.

Here is an example of Drawable animations which you can check out [here](https://github.com/Sefford/CircularProgressDrawable).

![](https://github.com/Sefford/CircularProgressDrawable/blob/master/overshoot.gif)

```
TODO: Add code Snippets Showing Implementation of Drawable Animation
```

### 4. Transitions
Android's transition framework allows you to animate all kinds of motion in your UI by simply providing the starting layout and the ending layout. You can select what type of animation you want (such to fade the views in/out or change the view sizes) and the transition framework figures out how to animate from the starting layout to the ending layout.

Here is an example of transitions which you can check out [here](https://github.com/kaichunlin/android-transition). 

![](https://github.com/kaichunlin/android-transition/blob/master/github/slideup_default.gif)

```
TODO: Add code Snippets Showing Implementation of Transitions
```

## License

MIT License

```Copyright (c) [2019] [AAD-Team-25]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
