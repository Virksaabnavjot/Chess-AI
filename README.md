# ChessProject-Artificial-Intelligence
Chess Project build with java programming language tools used Atom Hackable Editor, some initial code already provided by college. 

<img height="300px" weight="300px" src="https://github.com/Virksaabnavjot/ChessProject-Artificial-Intelligence/blob/master/src/atom/ScreenShot/Screen%20Shot%202016-10-16%20at%2017.15.39.png" />

This is the Screenshot at the begining and only the white pawn is functional and the rest is to be done from here.

# Understanding Chess Board on Paper
<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19583571/c9b61e84-9735-11e6-8f32-86e5e9bd592f.JPG" />

(Please click the image above to see it in correct orientation).

# x,y on Chess board (Horizontal and Vertical)
<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/20179140/9a180eae-a74c-11e6-9c32-20ca346a031d.png" />

# Understanding movement and landing of pieces on board 
<img height="300px" weight="300px" src="https://raw.githubusercontent.com/Virksaabnavjot/ChessProject-Artificial-Intelligence/665050affa50dca7f94542455da5d8bdf547099b/src/atom/ScreenShot/Learning%20Board%20Landing%20and%20Movement.png" />

# Knight's Logic
Knights moves:

Knight can only move in a L direction(meaning if movement on X-axis(xMovement) == 1, then the movement on Y-axis(yMovement) == 2 (must) and also the other way around.

Also, We need to check the square that we are moving to and make sure that if there is a piece present that its not our own piece.

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19577496/867dd10a-970f-11e6-9051-6f81b2e18b37.png" />

# Bishop's Logic
Bishop's moves: 

The bishop may move any number of squares on the same colured squares in a diagonal direction until it is prevented from continuing by another piece. It may then capture the opposing piece by landing on the square.
Bishop can't jump pieces unlike Knight.

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19582764/1c421056-972f-11e6-9b6d-2499a4e210cb.png" />

# Rook's Logic
Rook's Moves:

Rook can either move horizontally or vertically. It can move any number of squares but cannot pass through a piece.

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19584167/61aeb5b2-973a-11e6-9545-1e1ffd2aeff9.png" />

# Queen's Logic
Queen's moves:

The	Queen	(most powerful piece) can	move	in	a	horizontal,	vertical	or	diagonal direction	as	long	as	there	are	no	pieces	in the	way.

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19586188/cf81e8d8-974a-11e6-9ef2-4b28f6fab62d.png" />

Pseudo Code:

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19777776/b059b31a-9c71-11e6-93ed-35fc8ca8d00b.png" />

# King's Logic
King's Moves:

The King can move any direction 1 square at a time it can be horizontal, vertical or diagonal, the king cannot jump over pieces & cannot kills its own pieces and their must be 1 square distance between the opposing Kings else its an invalid move.

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/20179613/f49fe43a-a74e-11e6-9b3a-fc5a152e8805.png" />

Pseudo Code:

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/20179875/ffecfba6-a74f-11e6-8f5c-bf913eb1548d.png" />

# Helpful Code Explanations

```
int initialX; // Initial position of the piece on x-axis of the board at the start of the game
int initialY; // Initial position of the piece on y-axis of the board at the start of the game
```


```
int distance = Math.abs(startX-landingX);
```
Math.abs() method gives the absolute value of the argument (Absolute Value: the magnitude of a real number without regard to its sign) Source: https://www.tutorialspoint.com/java/number_abs.htm

<img src="https://cloud.githubusercontent.com/assets/5924811/20180287/c5f7cad2-a751-11e6-8ca7-f0cb2190442d.png" />


# Miscellaneous 

Actual Gameplay Images(Me against the computer)

(The pics are about 2-3 weeks old(from the day i started coding), game played during research phrase, I won the game, I loved playing chess since I was 15 years old and also loving this project so far and very excited to finish it and play on my own programmed chess board).

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19584190/97ecef2c-973a-11e6-9308-d76f2a9a0b81.JPG" />

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19584189/97d46a74-973a-11e6-849f-17c5f543c3ac.JPG" />

<img height="300px" weight="300px" src="https://cloud.githubusercontent.com/assets/5924811/19584191/97fe2b5c-973a-11e6-8b90-85fb2c4a8260.JPG" />









