export class AirlineAnalyticsQuery {

  from: string;
  to: string;
  reportType: string;

  constructor(fromDate: Date, toDate: Date, type: string) {
    this.reportType = type;

    let trueMonth = ('0' + fromDate['month']).slice(-2);
    let trueDay = ('0' + fromDate['day']).slice(-2);
    this.from = fromDate['year'] + '-' + trueMonth + '-' + trueDay;

    trueMonth = ('0' + toDate['month']).slice(-2);
    trueDay = ('0' + toDate['day']).slice(-2);
    this.to = toDate['year'] + '-' + trueMonth + '-' + trueDay;
  }
}
