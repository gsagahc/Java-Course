import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WeatherHomeComponent } from './modules/wheater/page/weather-home/weather-home.component';
import { WeatherCardComponent } from './modules/wheater/weather-card/weather-card.component';








@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule,
    CommonModule,
    
  ],
  declarations: [AppComponent, WeatherHomeComponent, WeatherCardComponent ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [CommonModule,
  BrowserModule,
  ],
})
export class AppModule {}
