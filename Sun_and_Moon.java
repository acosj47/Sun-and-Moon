// by Justin Acosta
// Proof of Concept
/*Sun and the moon 
 Learning how to make the sun and moon switch between each other and 
 change the sky color when they go off screen*/

//globals
float sunX, sunY, sunDX;     // sun x,y position and speed
float moonX, moonY, moonDX;  // moon x,y position and speed
float skyR;                  // r, g, b color for sky, defined in showScene()
float skyG;
float skyB; 
boolean sun, moon;          // conditional for sun and moon, defined in setup()

void setup() {
  size(400, 400);
  sunX = width/2;  // sun starts in the middle of screen 
  sunY = height/2;
  sunDX = 2;      // sun speed
  moonX = 0;      // moon starts on the left
  moonY = height/2;
  moonDX = 2;     // moon speed
  sun = true;     // sun starts on screen moon does not
  moon = false;
}

void draw() {
  background(skyR, skyG, skyB); // sky color determined by sun and moon in showScene()
  sunSwitch();
  showScene();
}

/* Note(what I learned) - if you put the code to move the sun and moon outside
 the "if(sun/moon == true)" code, their position will keep moving 
 even if they are not on screen.  This will cause them to appear
 in the middle of the screen as they switch.
 */

// shows & moves the sun and moon. Sky color is based on the sun and moon 
void showScene() {  
  if (sun == true) {    // the sun
    fill(255, 255, 0);
    ellipse(sunX, sunY, 30, 30);
    sunX += sunDX;  // move sun, sun only moves when true
    skyR = 100;     // sky is blue when the sun is out
    skyG = 150;
    skyB = 200;
  }

  if (moon == true) {   // the moon
    fill(150);
    ellipse(moonX, moonY, 30, 30);
    moonX += moonDX;  // move moon, moon only moves when true
    skyR = 100;       // sky is dark when moon is out
    skyG = 50;
    skyB = 200;
  }
}

// the moon and sun switch when they go off screen
void sunSwitch() {  
  if (sunX > width) {  // if the sun goes off screen
    sun = false; // sun goes away
    moon = true; // moon comes out
    sunX = 0;    // suns position returns to the left of screen
  }
  if (moonX > width) {  // if the moon goes off screen
    sun = true;   // sun comes back
    moon= false;  // moon goes away
    moonX = 0;    // moon position returns to left of screen
  }
}
