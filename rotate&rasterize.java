PImage img;

void setup() {
  size(900, 900, P3D);
  img = loadImage("bwpic.jpg");
  img.resize(900,900);
}

void draw() {
  background(#f1f1f1);
  fill(0);
  noStroke();

  float tiles = (mouseX/10);
  float tileSize = width/tiles;
  
  push();
  translate(width/2,height/2);
  rotateY(radians(frameCount));
    
  for (int x = 0; x < tiles; x++){
    for(int y = 0; y < tiles; y++){
      
      color c = img.get(int(x*tileSize),int(y*tileSize));
      float b = map(brightness(c),0,255,1,0);
      
      float z = map(b,0,1,-100,100);
      
      push();
      translate(x*tileSize - width/2,y*tileSize - height/2, z);
      ellipse(0,0,tileSize*b,tileSize*b);
      pop();
      
      
    }
  } 
  pop();
}
