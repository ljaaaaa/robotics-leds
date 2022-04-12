void move_array(CRGB _array[], int arr_size){
  CRGB old_array[arr_size];

  for (int x = 0; x < arr_size; x++){
    old_array[x].r = _array[x].r;
    old_array[x].g = _array[x].g;
    old_array[x].b = _array[x].b;
  }
  
  for (int x = 0; x < arr_size; x++){
    if (x == arr_size-1){
      _array[x] = old_array[0];
      
    } else {
      _array[x] = old_array[x+1]; 
    }
  }
}
