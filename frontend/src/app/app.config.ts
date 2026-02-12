import { ApplicationConfig, provideBrowserGlobalErrorListeners, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { LucideAngularModule, PiggyBank, Flame, NotebookPen, Plus, ArrowLeft } from 'lucide-angular';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    importProvidersFrom(
      LucideAngularModule.pick({ PiggyBank, Flame, NotebookPen, Plus, ArrowLeft })
    )
  ],
};
