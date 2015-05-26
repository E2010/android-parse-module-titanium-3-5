/* C++ code produced by gperf version 3.0.3 */
/* Command-line: /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/gperf -L C++ -E -t /private/var/folders/sc/qhz6wvtd0tb2l5xt4rjfxgsh0000gp/T/eileenzhang/android-titanium-parse-generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/private/var/folders/sc/qhz6wvtd0tb2l5xt4rjfxgsh0000gp/T/eileenzhang/android-titanium-parse-generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "com.ez2010.androidtitaniumparse.AndroidTitaniumParseModule.h"
#include "com.ez2010.androidtitaniumparse.ExampleProxy.h"


#line 14 "/private/var/folders/sc/qhz6wvtd0tb2l5xt4rjfxgsh0000gp/T/eileenzhang/android-titanium-parse-generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 15, duplicates = 0 */

class AndroidTitaniumParseBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
AndroidTitaniumParseBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct titanium::bindings::BindEntry *
AndroidTitaniumParseBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 2,
      MIN_WORD_LENGTH = 44,
      MAX_WORD_LENGTH = 58,
      MIN_HASH_VALUE = 44,
      MAX_HASH_VALUE = 58
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
#line 17 "/private/var/folders/sc/qhz6wvtd0tb2l5xt4rjfxgsh0000gp/T/eileenzhang/android-titanium-parse-generated/KrollGeneratedBindings.gperf"
      {"com.ez2010.androidtitaniumparse.ExampleProxy", ::com::ez2010::androidtitaniumparse::androidtitaniumparse::ExampleProxy::bindProxy, ::com::ez2010::androidtitaniumparse::androidtitaniumparse::ExampleProxy::dispose},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""},
#line 16 "/private/var/folders/sc/qhz6wvtd0tb2l5xt4rjfxgsh0000gp/T/eileenzhang/android-titanium-parse-generated/KrollGeneratedBindings.gperf"
      {"com.ez2010.androidtitaniumparse.AndroidTitaniumParseModule", ::com::ez2010::androidtitaniumparse::AndroidTitaniumParseModule::bindProxy, ::com::ez2010::androidtitaniumparse::AndroidTitaniumParseModule::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      unsigned int key = hash (str, len);

      if (key <= MAX_HASH_VALUE)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 18 "/private/var/folders/sc/qhz6wvtd0tb2l5xt4rjfxgsh0000gp/T/eileenzhang/android-titanium-parse-generated/KrollGeneratedBindings.gperf"

