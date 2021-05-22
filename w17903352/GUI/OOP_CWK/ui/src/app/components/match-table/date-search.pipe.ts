import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateSearch'
})
export class SearchPipe implements PipeTransform {

  transform(valueInArray: any, value?: any): any {
    if (!value) {
      return valueInArray;
    }
    // @ts-ignore
    return valueInArray.filter((val) => {
      let returnValue =  (val.date.toLocaleLowerCase().includes(value));
      return returnValue;
    })

  }

}

